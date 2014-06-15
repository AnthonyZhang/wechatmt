$("#addNewsBtn").click(function (){
	alert();
	var content = ue.getContent();
	$("#newsContent").text = content;
	console.log(content);
	$("#addNewsForm").submit();
});
