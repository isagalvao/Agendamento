/**
 * validação do formulario de horário
 */

 function validar(){
	 let data = frmAgendamento.data.value
	 let hora = frmAgendamento.hora.value
	 if(data === ""){
		 alert('Preencha o campo data')
		 frmAgendamento.data.focus
		 return false
	 } else if(hora === ""){
		  alert('Preencha o campo hora')
		 frmAgendamento.hora.focus
		 return false
	 } else{
		 document.forms["frmAgendamento"].submit()
	 }
 }