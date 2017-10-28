$(document).ready(function () {
//	$('.button-collapse').sideNav();
	// Initialize collapsible (uncomment the line below if you use the dropdown variation)
//	$('.collapsible').collapsible();
	
//	if($('#slide-out').is(':hidden')){
//		$('.button-collapse').sideNav('show');
//	}else{
//		$('.button-collapse').sideNav('hide');
//	}
	 $('select').material_select();

	 var opt = $('.input-field option:disabled');
	 if (opt.length) {

	 	var field = opt.parents('.select-wrapper');
	 	opt.reverse();
	 	field.each(function(index,value){
	 		$(this).children('input.select-dropdown').prop('value',opt[index].text);
	 	});
	 }

	 $('#left-sidebar-nav #slide-out').perfectScrollbar();
});
