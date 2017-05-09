$(document).ready(function() {
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
			$('#agileinfo_search').click(function(){
				if($('#search-info').css("display")=='none'){
					$('#search-info').css("display","block");
				}else{
					$('#search-info').css("display","none");
				}
			});
		});