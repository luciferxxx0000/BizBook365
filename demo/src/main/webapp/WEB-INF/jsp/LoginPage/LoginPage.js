function togglePassword() {
    const passwordInput = document.getElementById('password');
    const toggle = document.querySelector('.password-toggle');

    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        toggle.textContent = '🙈';
    } else {
        passwordInput.type = 'password';
        toggle.textContent = '👁️';
    }
}

document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const remember = document.getElementById('remember').checked;

    console.log('Login Data:', {
        email: email,
        password: password,
        remember: remember
    });

    if (email === 'demo@bizbook360.com' && password === 'demo123') {
        alert('Login Successful !');
    } else {
        showError();
    }
});

function showError() {
    const errorMsg = document.getElementById('errorMessage');
    errorMsg.style.display = 'block';

    setTimeout(() => {
        errorMsg.style.display = 'none';
    }, 3000);
}

function googleLogin() {
    console.log('Google login initiated');
    alert('Google login feature coming soon!');
    // මෙතන Google OAuth implementation එක කරන්න පුළුවන්
}

function microsoftLogin() {
    console.log('Microsoft login initiated');
    alert('Microsoft login feature coming soon!');
    // මෙතන Microsoft OAuth implementation එක කරන්න පුළුවන්
}

// Demo credentials hint in console
console.log('%c Demo Credentials:', 'color: #667eea; font-weight: bold; font-size: 14px;');
console.log('%c Email: demo@bizbook360.com', 'color: #666; font-size: 12px;');
console.log('%c Password: demo123', 'color: #666; font-size: 12px;');