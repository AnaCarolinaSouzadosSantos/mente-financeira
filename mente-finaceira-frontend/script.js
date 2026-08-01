

// 1. Pega o formulário de login lá do HTML usando o ID dele
const formularioLogin = document.getElementById('formLogin');

// 2. Cria um "espião" (EventListener) que fica ouvindo quando o usuário clica no botão "Entrar" (submit)
formularioLogin.addEventListener('submit', function(evento) {
    
    // 3. Bloqueia o comportamento padrão da página (evita que a tela recarregue/pisque)
    evento.preventDefault();

    // 4. Captura o que o usuário digitou dentro das caixinhas de e-mail e senha
    const emailDigitado = document.getElementById('email').value;
    const senhaDigitada = document.getElementById('senha').value;

    // 5. Um teste simples: mostra os dados num alerta na tela para provar que funcionou!
    alert("JavaScript capturou os dados!\nE-mail: " + emailDigitado + "\nSenha: " + senhaDigitada);

    // NOTA PARA O FUTURO: Depois do curso do Guanabara, vamos trocar esse 'alert' 
    // pelo comando 'fetch()' para mandar esses dados direto para o seu servidor Java.
});