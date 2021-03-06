/*
 * 
 * */

$(document).ready(function() {

	// Rutas
	page('/', index);
	page('/help', help);
	page('/administrar', administrar);
	page('/elecciones', list);
	page('/elecciones/:eleccion', eleccion);
	page('*', notfound);

	page('/');
	
	$(document.body).on("click","a", function(e){
		e.preventDefault();
		page($(this).attr("href"));
	})

	// Botones Admin
	$("#iniciarRecuento").on("click", function() {
		$.ajax({
			url : "/iniciarRecuento/" + $("#idEleccion").val()
		}).then(function(data) {
			addAlert("Recuento iniciado.", "success");
		});
	});

	$("#terminarRecuento").on("click", function() {
		$.ajax({
			url : "/terminarRecuento/" + $("#idEleccion").val()
		}).then(function(data) {
			addAlert("Recuento terminado.", "success");
		});
	});

	$('#adminForm').on('submit', function(e) {
		e.preventDefault();
	});

});

/* Activa los enlaces del NAV con determinado href */
var navTo = function(href, idPage) {
	$("#navbar .navbar-nav .active").removeClass("active");
	$('#navbar .navbar-nav a[href$="' + href + '"]').parent()
			.addClass("active");
	$("#main > .page.active").removeClass("active");
	$("#" + idPage).addClass("active");
}

var index = function() {
	navTo("/", "index");
}

var help = function() {
	navTo("/help", "help");
}

var administrar = function() {
	navTo("/administrar", "administrar");
}

var list = function() {
	navTo("/elecciones", "elecciones");

	$.ajax({
		url : "/elecciones"
	}).then(function(data) {
		console.log(data)
		var listadoT = doT.template(document.getElementById('ListTpl').text);
		console.log(listadoT, listadoT(data));
		document.getElementById('listaElecciones').innerHTML = listadoT(data);
	});
}

var eleccion = function(arg) {
	console.log(arg.params);
	
	
	$.ajax({
		url : "/eleccion/" + arg.params.eleccion
	}).then(function(data) {
		console.log(data)
		drawChart(data);
		navTo("nanannana", "eleccion");
	});

}

var notfound = function() {
	navTo("/notFound", "notFound");
}

var submitActionFactory = (function() {

	var request;

	return (function(params) {

		$(params.el).submit(function(e) {
			e.preventDefault();

			var $form = $(this);

			// Abort any pending request
			if (request) {
				request.abort();
			}

			// Let's select and cache all the fields
			var $inputs = $form.find("input, select, button, textarea");

			// Serialize the data in the form
			var data = {};
			$form.serializeArray().map(function(x) {
				data[x.name] = x.value;
			});

			// Let's disable the inputs for the duration of the Ajax request.
			$inputs.prop("disabled", true);

			// Fire off the request
			console.log("Request", data);
			request = $.ajax({
				url : params.url,
				type : "post",
				contentType : "application/json",
				dataType : "json",
				data : JSON.stringify(data)
			});

			// Callback handler that will be called on success
			request.done(params.done);

			// Callback handler that will be called on failure
			request.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("Response");
				console.error(jqXHR, textStatus, errorThrown);

				if (jqXHR.status == 404) {
					params.error404();
				} else {
					// otro error desconocido
					alert("Ocurrió un error desconocido.");
					console.error(textStatus, errorThrown);
				}
			});

			// if the request failed or succeeded
			request.always(function() {
				// Reenable the inputs
				$inputs.prop("disabled", false);
			});

		});
	});
})();

function addAlert(message, level) {
	$('#alerts')
			.append(
					'<div class="alert alert-'
							+ (level != undefined ? level : 'danger')
							+ ' alert-dismissible fade in">'
							+ '<button type="button" class="close" data-dismiss="alert">'
							+ '&times;</button>' + message + '</div>');
}

function drawChart(barData) {
	console.log("Creando grafica..");
	
	
	$("#chart-wrap").html('<svg id="ChartResultadosEleccion" width="1000" height="500"></svg>')
	
	var chart = d3.select('#ChartResultadosEleccion');
	var WIDTH = 1000,
		HEIGHT = 500,
		MARGINS = {
			top : 20,
			right : 20,
			bottom : 20,
			left : 50
		},
		xRange = d3.scale.ordinal().rangeRoundBands(
				[ MARGINS.left, WIDTH - MARGINS.right ], 0.1).domain(
				barData.map(function(d) {
					return d.x;
				})),

		yRange = d3.scale.linear().range([ HEIGHT - MARGINS.top, MARGINS.bottom ])
				.domain([ 0, d3.max(barData, function(d) {
					return d.y;
				}) ]),

		xAxis = d3.svg.axis().scale(xRange).tickSize(5).tickSubdivide(true),
	
		yAxis = d3.svg.axis().scale(yRange).tickSize(5).orient("left").tickSubdivide(true);

	chart.append('svg:g').attr('class', 'x axis').attr('transform',
			'translate(0,' + (HEIGHT - MARGINS.bottom) + ')').call(xAxis);

	chart.append('svg:g').attr('class', 'y axis').attr('transform',
			'translate(' + (MARGINS.left) + ',0)').call(yAxis);

	chart.selectAll('rect').data(barData).enter().append('rect').attr('x',
			function(d) {
				return xRange(d.x);
			}).attr('y', function(d) {
		return yRange(d.y);
	}).attr('width', xRange.rangeBand()).attr('height', function(d) {
		return ((HEIGHT - MARGINS.bottom) - yRange(d.y));
	}).attr('fill', function() {
		return randomColor();
	}).on('mouseover', function(d) {
		d3.select(this).attr("style", "outline: thin solid black;");
	}).on('mouseout', function(d) {
		d3.select(this).attr('style', 'outline: none;');
	});

}
