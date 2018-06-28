//alert("323");
$(function(){
	var html,risk
	var htmlArray=new Array()
	 $.ajax({
       type: "get",
       async: false,
       url: "/list/app",
//       dataType: "jsonp",
//       jsonp: "callback",
//       jsonpCallback:"flightHandler",
       success: function(data){
    	//   alert(data)
    	    var json=eval(data);
    	// alert(json);
         for(var i=0; i<json.length;i++){
		if(json[i].level=="低"){
        			risk = "riskL";
        		}
        		if(json[i].level=="中"){
        			risk = "riskC";
        		}
        		if(json[i].level=="高"){
        			risk = "riskH";
        		}
        		//+' '+json[i].time.substring(17,19)
        		html = "<li><span>"+json[i].time.substring(11,16)+"</span><span>"+
        		json[i].location+"</span> <b class='"+risk+"'></b></li>";
        		htmlArray[i] = html;
            }
            var a = 0;
			function notice(){
				var html = htmlArray[a];
				$("#notice").prepend(html);
				a++;
				if(a == json.length){
					clearInterval(timer);
				}
			}
			var timer = setInterval(notice,2000);
       }
     })
//$(function(){s
//	
//	 $.ajax({
//       type: "get",
//       async: false,
//       url: "list/all",
//       dataType: "jsonp",
//       jsonp: "callback",
//       jsonpCallback:"flightHandler",
//       success: function(data){
//    	   alert(data);
//         alert(data[0].data[0].id);
//       },
//       error: function(){
//         alert('fail');
//       }
//     })
     
//     $.get("list/all",
//    	function(date){
//    	 var r=eval(date);
//    	 alert(r.length);
//    	 for(var i=0;i<r.length;i++){
//    		 alert("时间："+r[i].time+"地点"+r[i].location);
//    	 }
//     }	 
//     );
	/*var html,risk;
	$.ajax({ 
            url: "http://192.168.4.149:8085/list", 
            type: "POST", 
            dataType: 'jsonp', 
            success: function(data) {
            	console.log(1);
            	for(var i=0; i<data[0].length;i++){
            		setTimeout(function(){
				　　　　if(data[0][i].level=="低"){
	            			risk = "riskL";
	            		}
	            		if(data[0][i].level=="中"){
	            			risk = "riskC";
	            		}
	            		if(data[0][i].level=="高"){
	            			risk = "riskH";
	            		}
	            		html = "<li><span>"+data[0][i].time.substring(11)+"</span><span>"+
	            		data[0][i].time.location+"</span> <b class='"+risk+"'></b></li>";
	            		$("#notice").prepend(html);
				　　},i*2000);
            		
            	}
            } ,
            error:function(){
            	console.log(2);
            }
        });*/
	// var a = 0;
	// function notice(){
	// 	var html = "<li><span>20:2"+a+"</span><span>正门警告</span> <b class='riskH'></b></li>";
	// 	$("#notice").prepend(html);
	// 	a++;
	// 	if(a == 10){
	// 		clearInterval(timer);
	// 	}
	// }
	// var timer = setInterval(notice,2000);
})