function nepaliToEnglish(nepalidate,englishdate){
			var date = $(nepalidate).val();
			var dataString = {
				'nepalidate' : date
			};
			
			$.ajax({
				type : "POST",
				url : "nepaliToEnglish.click",
				data : dataString,
				cache : false,
				success : function(html) {
					$(englishdate).val(html);
				},
				error : function() {
					$alert("error occured");
				}
			});
		}
		function englishToNepali(nepalidate,englishdate){
			var date = $(englishdate).val();
			var dataString = {
				'englishdate' : date
			};
			$.ajax({
				type : "POST",
				url : "englishToNepali.click",
				data : dataString,
				cache : false,
				success : function(html) {
					$(nepalidate).val(html);
				},
				error : function() {
					$alert("error occured");
				}
			});
		}