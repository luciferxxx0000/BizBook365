// Password Toggle Function
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

// Form Submission Handler
document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const remember = document.getElementById('remember').checked;

    // Backend API call එකක් කරන්න පුළුවන් මෙතන
    console.log('Login Data:', {
        email: email,
        password: password,
        remember: remember
    });

    // Demo validation (Backend integration සඳහා මේක වෙනස් කරන්න)
    if (email === 'demo@bizbook360.com' && password === 'demo123') {
        // Success
        alert('✅ Login Successful! Welcome to BizBook360');

        // Redirect to dashboard
        // window.location.href = '/dashboard.html';

        // හෝ Backend API call එකක්
        // loginToBackend(email, password, remember);
    } else {
        // Show error message
        showError();
    }
});

// Show Error Message Function
function showError() {
    const errorMsg = document.getElementById('errorMessage');
    errorMsg.style.display = 'block';

    // Hide after 3 seconds
    setTimeout(() => {
        errorMsg.style.display = 'none';
    }, 3000);
}

// Google Login Function
function googleLogin() {
    console.log('Google login initiated');
    alert('🔍 Google login feature coming soon!');

    // Google OAuth implementation එක මෙතන කරන්න පුළුවන්
    // window.location.href = '/api/auth/google';
}

// Microsoft Login Function
function microsoftLogin() {
    console.log('Microsoft login initiated');
    alert('Ⓜ️ Microsoft login feature coming soon!');

    // Microsoft OAuth implementation එක මෙතන කරන්න පුළුවන්
    // window.location.href = '/api/auth/microsoft';
}

// Backend Login API Call Function (Spring Boot integration සඳහා)
async function loginToBackend(email, password, remember) {
    try {
        const response = await fetch('/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password,
                remember: remember
            })
        });

        const data = await response.json();

        if (data.success) {
            // Login successful
            console.log('Login successful:', data);

            // Store token if using JWT
            if (data.token) {
                localStorage.setItem('authToken', data.token);
            }

            // Redirect to dashboard
            window.location.href = '/dashboard.html';
        } else {
            // Login failed
            console.error('Login failed:', data.message);
            showError();
        }
    } catch (error) {
        console.error('Login error:', error);
        showError();
    }
}

// Input Animation - Focus Effects
document.querySelectorAll('input').forEach(input => {
    input.addEventListener('focus', function() {
        this.parentElement.parentElement.classList.add('focused');
    });

    input.addEventListener('blur', function() {
        this.parentElement.parentElement.classList.remove('focused');
    });
});

// Smooth Scroll for Links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
    });
});

// Demo Credentials Console Log
console.log('%c 🎯 Demo Credentials:', 'color: #667eea; font-weight: bold; font-size: 16px;');
console.log('%c Email: demo@bizbook360.com', 'color: #666; font-size: 13px;');
console.log('%c Password: demo123', 'color: #666; font-size: 13px;');

// Prevent form submit on Enter in specific fields (optional)
document.getElementById('email').addEventListener('keypress', function(e) {
    if (e.key === 'Enter') {
        document.getElementById('password').focus();
        e.preventDefault();
    }
});

// Auto-focus email field on page load
window.addEventListener('load', function() {
    document.getElementById('email').focus();
});

// Session timeout warning (optional - for security)
let sessionTimeout;
function resetSessionTimeout() {
    clearTimeout(sessionTimeout);
    // 30 minutes session timeout
    sessionTimeout = setTimeout(() => {
        alert('⏰ Your session has expired. Please login again.');
        window.location.reload();
    }, 30 * 60 * 1000);
}

// Reset session timeout on user activity
document.addEventListener('mousemove', resetSessionTimeout);
document.addEventListener('keypress', resetSessionTimeout);
resetSessionTimeout();

// Loading animation (optional - when submitting form)
function showLoadingAnimation() {
    const button = document.querySelector('.btn-login');
    button.innerHTML = '<span>⏳ Logging in...</span>';
    button.disabled = true;
}

function hideLoadingAnimation() {
    const button = document.querySelector('.btn-login');
    button.innerHTML = 'Login';
    button.disabled = false;
}