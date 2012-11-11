<%
String button = "play";
if (request.getParameter("button") != null) {
	button = request.getParameter("button") + "";
}
%>
<html>
  <head>
    <script src="codemirror2/lib/codemirror.js" type="text/javascript"></script>
    <script src="codemirror2/mode/javascript/javascript.js" type="text/javascript"></script>
    <link rel="stylesheet" href="codemirror2/lib/codemirror.css"></link>
    <link rel="stylesheet" href="codemirror2/theme/eclipse.css"></link>
    
    <script type="text/javascript">
	    
	    var http = createRequestObject();

	    function createRequestObject() {
	    	var objAjax;
	    	var browser = navigator.appName;
	    	if(browser == "Microsoft Internet Explorer"){
	    		objAjax = new ActiveXObject("Microsoft.XMLHTTP");
	    	}else{
	    		objAjax = new XMLHttpRequest();
	    	}
	    	return objAjax;
	    }

	    function run(){
			
			document.getElementById("run").src = "images/clock.png";
			
			var url = "evaluate?language=<%= request.getParameter("language") %>&source=" + encodeURIComponent(source_editor.getValue());
			
	    	http.open("get", url);
	    	
	    	http.onreadystatechange = updateNewContent;
	    	http.send(null);
	    	return false;
	    }

	    function updateNewContent(){
	    	
	    	if(http.readyState == 4){
	    		
	    		var response;
	    			
	    		if (http.status == "200") {
	    			response = http.responseText;			
	    		}
	    		else {
	    			response = "An unexpected error occurred. Sorry :(";
	    		}
				
	    		console.setValue(response);
	    		document.getElementById("run").src = "images/<%=button%>.png";
		    }
	    }

	</script>
  </head>
  <body>
  
  	<textarea id="source_area" style=""><%= request.getParameter("source") %></textarea>
		
		<center>
			<input id="run" type="image" src="images/<%=button%>.png" style="padding:20px" onclick="run()"/>
		</center>
		
  		<textarea id="console_area" style="height:100px;"></textarea>
  		
		<script type="text/javascript">
			var source_editor = CodeMirror.fromTextArea(document.getElementById("source_area"), {lineNumbers: true});		
			var console = CodeMirror.fromTextArea(document.getElementById("console_area"), {lineNumbers: true}); 		
  			var editors = document.getElementsByClassName("codeMirror-scroll");
  			editors[1].style.height="150px";
  			editors[1].refresh();
		</script>

  </body>
</html>