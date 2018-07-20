jQuery对ajax操作就进行了封装，在jQuery中有三个层次,列举了几个最常用的：
最底层：$.ajax()
其次：load(),$.get(),$.post()
最高层：$.getScript(),$.getJSON()

$(selector).load(url,args,callbacks]):最简单和最常用
$(obj).load(url,args,callbacks);
$('#content').load(url,args);


$.get(url,callback,type):
$("button").click(function(){
  $.get("demo_test.asp",function(data,status){
    alert("Data: " + data + "\nStatus: " + status);
  });
});

//args为json格式
$.post(url,arguments,callback):
$("button").click(function(){
  var args = {"time":new Date()};
  $.get("demo_test.asp",,function(data,status){
    alert("Data: " + data + "\nStatus: " + status);
  });
});

//getJSON使用的时get方法的xhr
$(selector).getJSON(url,args,success(data,status,xhr))
$.getJSON(url,args,function (data) {
    var name = data.name;
    var website = data.website;
    var email = data.email;

    $("#details").empty()
        .append("<h2><a href='mailto:" + email + "'>" + name + "</a></h2>")
        .append("<a href='" + website + "'>" + website + "</a>");
});

$.ajax({name:value, name:value, ... })
http://api.jquery.com/jQuery.ajax/
$("button").click(function(){
    $.ajax({url:"demo_test.txt",success:function(result){
        $("#div1").html(result);
    }});
});

