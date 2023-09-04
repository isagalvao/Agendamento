/**
 * confirmando desejo de cancelar agendamento
 */

 function confirmar(idagendamento){
	 let resposta = confirm("confirma o cancelamento desse agendamento?")
	 if(resposta === true){
		 //alert(idagendamento)
		 window.location.href = "delete?idagendamento=" + idagendamento
	 }
 }