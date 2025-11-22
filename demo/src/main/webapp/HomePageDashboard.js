// Animate numbers
function animateValue(id, start, end, duration, prefix = '', suffix = '') {
    const obj = document.getElementById(id);
    const range = end - start;
    const increment = end > start ? 1 : -1;
    const stepTime = Math.abs(Math.floor(duration / range));
    let current = start;

    const timer = setInterval(() => {
        current += increment;
        obj.textContent = prefix + current.toLocaleString() + suffix;
        if (current === end) {
            clearInterval(timer);
        }
    }, stepTime);
}

// Page load stats animation
window.addEventListener('load', () => {
    animateValue('customerCount', 0, 45, 1000);
    animateValue('invoiceCount', 0, 128, 1000);
    animateValue('revenue', 0, 5000, 1500, 'Rs. ');
    animateValue('pending', 0, 12, 1000);
});

function navigate(page) {
    alert(`Navigating to "${page}" page... (This is a demo. In the full application this will work.)`);
}

function getStarted() {
    alert('Let’s get started! First enter your business details.');
}
