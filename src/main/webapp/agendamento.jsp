<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("agendamento");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">

<script defer src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script defer src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script defer src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
<script defer src="scripts/script.js"></script>"

<meta charset="utf-8"> <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
<title>Lista de agendamento</title>
<link rel="icon" href="imagens/calendario.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="cabecalho">
		<img class="icone" src="imagens/calendario.png">
		<h2>GYM SCHEDULE</h2>
	</div>
	<div class="div1 divpad">
		<h1>Meus Agendamentos - apartamento null</h1>

		<table id="example" class="table table-striped" style="width:60%">
			<thead>
				<tr>
					<th>Id</th>
					<th>Id morador</th>
					<th>Data</th>
					<th>Hora</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getIdagendamento()%></td>
					<td><%=lista.get(i).getIdmorador()%></td>
					<td><%=lista.get(i).getData()%></td>
					<td><%=lista.get(i).getHora()%></td>
					<td><a
						href="javascript: confirmar(<%=lista.get(i).getIdagendamento()%>)"
						class="Botao2">Cancelar agendamento</a>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

	</div>

	<div class="div2 divpad">
		<h1>Realização de Agendamentos</h1>

		<form name="frmAgendamento" action="inserir">
			<table>
				<tr>
					<td><label class="textin" for="data">Dia do
							agendamento:</label> <input class="calendar" type="date" id="data"
						name="data"></td>
				</tr>
				<tr>
					<td><label class="textin" for="hora">Selecione o
							horário:</label> <input class="relogio" type="time" id="hora" name="hora"
						step="3600000"></td>
				</tr>
			</table>
			<input class="Botao1" type="button" value="Agendar"
				onclick="validar()">

		</form>
	</div>

	
	<script src="scripts/validador.js"></script>
	<script src="scripts/confirmador.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
</body>
</html>