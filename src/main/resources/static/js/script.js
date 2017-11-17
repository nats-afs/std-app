$(document).ready(function() {
	//	$('.button-collapse').sideNav();
	// Initialize collapsible (uncomment the line below if you use the dropdown variation)
	//	$('.collapsible').collapsible();

	//	if($('#slide-out').is(':hidden')){
	//		$('.button-collapse').sideNav('show');
	//	}else{
	//		$('.button-collapse').sideNav('hide');
	//	}

	$('select').material_select();


	// SELECT OPTION 
	var opt = $('.input-field option:disabled');
	if (opt.length) {

		var field = opt.parents('.select-wrapper');
		opt.reverse();
		field.each(function(index, value) {
			$(this).children('input.select-dropdown').prop('value', opt[index].text);
		});
	}
	// FIN SELECT OPTION

	// PERFECT SCROOLBAR
	$('#left-sidebar-nav #slide-out').perfectScrollbar();
	// FIN PERFECT SCROOLBAR

	// PAGINATION ACTIVE LINK
	// var links = $('.pagination li:not(:has(a i.material-icons))');

	// links.on('click', function() {
	// 	$(this).addClass('active').siblings().removeClass('active');
	// });
	// FIN PAGINATION ACTIVE LINK

	changePageAndSize();

	$(function() {
		$('#pageSizeSelect').on('change', function() {
			$("section").load('claimants');
		});
	});

	// $(function() {
	// 	$('#pageSizeSelect').on('change', function() {
	// 		$("tbody").load('claimants/ajax?size='+ this.value);
	// 		$("ul.pagination").load('claimants/ajax?size='+ this.value);
	// 	});
	// });
 
});

	function changePageAndSize() {
		$('#pageSizeSelect').change(function(evt) {
			window.location.replace("/claimants?size=" + this.value + "&page=0");
		});
	}

