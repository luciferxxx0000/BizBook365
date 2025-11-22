// Password toggle functionality
const togglePasswordButtons = document.querySelectorAll('.toggle-password');

togglePasswordButtons.forEach(button => {
    button.addEventListener('click', function() {
        const targetId = this.getAttribute('data-target');
        const input = document.getElementById(targetId);

        if (input.type === 'password') {
            input.type = 'text';
        } else {
            input.type = 'password';
        }
    });
});

// Form submission
document.getElementById('signupForm').addEventListener('submit', function(e) {
    e.preventDefault();

    // Get form values
    const fullName = document.getElementById('fullName').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    const termsChecked = document.getElementById('terms').checked;

    // Validate passwords match
    if (password !== confirmPassword) {
        alert('Passwords do not match! Please try again.');
        return;
    }

    // Validate password strength (minimum 6 characters)
    if (password.length < 6) {
        alert('Password must be at least 6 characters long!');
        return;
    }

    // Validate terms acceptance
    if (!termsChecked) {
        alert('Please accept the Terms & Conditions to continue.');
        return;
    }

    // Success message
    alert(`Account created successfully!\n\nName: ${fullName}\nEmail: ${email}\nPhone: ${phone}\n\nYou can now login to your account.`);

    // In a real application, you would send this data to your backend server
    // Example:
    // fetch('/api/signup', {
    //     method: 'POST',
    //     headers: { 'Content-Type': 'application/json' },
    //     body: JSON.stringify({ fullName, email, phone, password })
    // })
    // .then(response => response.json())
    // .then(data => {
    //     if (data.success) {
    //         window.location.href = 'LoginPage.html';
    //     }
    // });

    // Redirect to login page
    window.location.href = 'LoginPage.html';
});

// Google signup
document.getElementById('googleSignup').addEventListener('click', function() {
    alert('Sign up with Google - This would connect to Google OAuth');
    // In real application:
    // window.location.href = '/auth/google';
});

// Microsoft signup
document.getElementById('microsoftSignup').addEventListener('click', function() {
    alert('Sign up with Microsoft - This would connect to Microsoft OAuth');
    // In real application:
    // window.location.href = '/auth/microsoft';
});

// Terms link
document.querySelector('.terms-link').addEventListener('click', function(e) {
    e.preventDefault();
    alert('Terms & Conditions page would open here');
    // In real application:
    // window.open('terms.html', '_blank');
});

// Email validation
document.getElementById('email').addEventListener('blur', function() {
    const email = this.value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (email && !emailRegex.test(email)) {
        alert('Please enter a valid email address');
        this.focus();
    }
});

// Phone validation (Sri Lankan format - 10 digits)
document.getElementById('phone').addEventListener('blur', function() {
    const phone = this.value;
    const phoneRegex = /^[0-9]{10}$/;

    if (phone && !phoneRegex.test(phone)) {
        alert('Please enter a valid 10-digit phone number');
        this.focus();
    }
});