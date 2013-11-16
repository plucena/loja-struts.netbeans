<%@page import="com.unasp.forms.PessoasForm"%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
</head>
<body>
  Cadastro de Pessoas
  
  <% 
     PessoasForm dados = null;
     if(session.getAttribute("pessoa")!=null)  
        dados = (PessoasForm) session.getAttribute("pessoa");  
     else 
       dados = new PessoasForm();   
 %>
  
  <html:form action="/Pessoas">
  <table width="80%" border="0">      
  <tr> <td>CPF:</td> <td><html:text property="cpf" value="<%=dados.getCpf()%>"/></td> </tr>    
  <tr><td>Nome:</td> <td><html:text property="nome" value="<%=dados.getNome()%>"/> </td></tr>
  <tr><td>Telefone:</td> <td><html:text property="telefone" value="<%=dados.getTelefone()%>" /> </td></tr>
  <tr><td>Email:</td> <td><html:text property="email" value="<%=dados.getEmail()%>"/></td></tr>
  </table>
  <html:select property="acao">
      <html:option value="Procurar">Procurar</html:option>
      <html:option value="Cadastrar">Cadastrar</html:option>      
      <html:option value="Alterar">Alterar</html:option>
      <html:option value="Excluir">Excluir</html:option>
  </html:select>  
  <html:submit />
  </html:form>
</body>
</html> 
