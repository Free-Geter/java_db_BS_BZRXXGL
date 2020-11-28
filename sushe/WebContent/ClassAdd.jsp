<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生信息管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.)Class_Name.value){  
   alert("请输入班级名！"); 
   return false;
   }
   if(isNull(form1.Class_Dept.value)){
   alert("请输入专业！");
   return false;
   }
   if(isNull(form1.Class_Time.value)){
   alert("请选择入学时间！");
   return false;
   }
   if (isNull(form1.Class_Number.value)) { 
   alert("请输入班级人数！"); 
   return false; 
   }  
   if(isNull(form1.Class_Teacher.value)){
   alert("请选择班主任！");
   return false;
   }
   if(isNull(form1.Class_Back.value)){
   alert("请选择学历！");
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">学生信息管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">添加班级</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="ClassAddSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>班级名：</td>
                    <td><input name="Class_Name" type="text" class="text2" id="Class_Name"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>专业：</td>
                    <td><input name="Class_Dept" type="text" class="text2" id="Class_Dept"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>班级人数：</td>
                    <td><input name="Class_Number" type="text" class="text2" id="Class_Number"></td>
                  </tr>
                 <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>班主任：</td>
                    <td><select name="Class_Teacher" id="Class_Teacher">
                      <option value="">请选择</option>
                      <s:iterator value="list">
                        <option value="${Teacher_ID}">${Teacher_Name}</option>
                      </s:iterator>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>班级学历：</td>
                    <td><select name="Class_Back" id="Class_Back">
                      <option value="">请选择</option>
                      <option value="本科">本科</option>
                      <option value="研究生">研究生</option>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>入学时间：</td>
                    <td><label for="Class_Time"></label>
                      <input type="text" name="Class_Time" id="Class_Time" class="Wdate" onClick="WdatePicker()"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="添加班级">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
