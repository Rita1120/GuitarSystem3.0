<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="guitar.Model.Type" %>
 <%@ page import="guitar.Model.Wood" %>
 <%@ page import="guitar.Model.Builder" %>
 <%@ page import="guitar.Model.Guitar" %>
 <%@ page import="guitar.Model.GuitarSpec" %>
 <%@ page import="guitar.IDao.GuitarIDao" %>
 <%@ page import="guitar.IDaoImpl.GuitarIDaoImpl" %>
 <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js"></script>
<title>添加吉他</title>
</head>
<body>
<form action="addGuitar" method="post">
<label>吉他编号</label><input type="text" name="serialNumber" placeholder="请输入吉他编号">
<label>价格</label><input type="text" name="price" placeholder="请输入吉他价格">
<label>生产商：</label><select name="builder" id="builder" >
                                              <option></option>
                                              <% for(int  i = 0; i<Builder.values().length;i++){%>
                                              <option value="<%=Builder.values()[i]%>"><%=Builder.values()[i]%></option>
                                              <%} %>
                                           </select>
<label>型号：</label><select name="model" id="model" >
                                            <option></option>
                                            <option value="STRATOCASTOR">STRATOCASTOR</option>
                                            <option value="CJ">CJ</option>
	                                        <option value="YAMAHA">YAMAHA</option>
                                      </select>
<br><br>
<label>类型：</label><select name="type" id="type">
                                          <option></option>
                                           <% for(int  i = 0; i<Type.values().length;i++){%>
                                              <option value="<%=Type.values()[i]%>"><%=Type.values()[i]%></option>
                                              <%} %>
                                          </select>
<label>背板木：</label><select name="backWood" id="backWood" >
                                              <option></option>
                                                 <% for(int  i = 0; i<Wood.values().length;i++){%>
                                              <option value="<%=Wood.values()[i]%>"><%=Wood.values()[i]%></option>
                                              <%} %>
                                           </select>
<label>顶端木：</label><select name="topWood" id="topWood" >
                                               <option></option>
                                                <% for(int  i = 0; i<Wood.values().length;i++){%>
                                                <option value="<%=Wood.values()[i]%>"><%=Wood.values()[i]%></option>
                                                 <%} %>
                                          </select>
<br><br>
&nbsp;&nbsp;&nbsp;
<input type="submit" name="add" id="add"  value="添加">
&nbsp;&nbsp;&nbsp;
<input type="reset" name="reset" value="重置">
</form>
<a href="findGuitar.jsp">查询吉他</a>
<script type="text/javascript">
//获取参数   
function getUrlParam(name){  
    //构造一个含有目标参数的正则表达式对象  
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");  
    //匹配目标参数  
    var r = window.location.search.substr(1).match(reg);  
    //返回参数值  
    if (r!=null) return unescape(r[2]);  
    return null;  
}
$(document).ready(function(){
	var msg=getUrlParam('msg');
	if(msg==1){
		alert("添加成功");
	}else if(msg==2){
		alert("添加失败 ");
	}
     else{	}
}); 
</script>
</body>
</html>