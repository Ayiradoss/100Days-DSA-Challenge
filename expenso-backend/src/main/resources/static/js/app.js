// Shared frontend JS for Expenso
const apiBase = '';

function setUser(user) {
  localStorage.setItem('expenso_user', JSON.stringify(user));
}

function getUser() {
  const s = localStorage.getItem('expenso_user');
  return s ? JSON.parse(s) : null;
}

function logout() {
  localStorage.removeItem('expenso_user');
  window.location.href = 'login.html';
}

async function registerUser(data) {
  const res = await fetch(apiBase + '/api/auth/register', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
  });
  return res;
}

async function loginUser(data) {
  const res = await fetch(apiBase + '/api/auth/login', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
  });
  return res;
}

async function fetchCategories() {
  const res = await fetch(apiBase + '/api/categories');
  if (!res.ok) return [];
  return res.json();
}

async function addExpense(payload) {
  const res = await fetch(apiBase + '/api/expenses', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(payload)
  });
  return res;
}

async function fetchExpenses() {
  const res = await fetch(apiBase + '/api/expenses');
  if (!res.ok) return [];
  return res.json();
}

async function deleteExpense(id) {
  return fetch(apiBase + '/api/expenses/' + id, { method: 'DELETE' });
}

// Utility helpers
function showAlert(container, message, type = 'danger') {
  if (!container) return;
  container.innerHTML = `<div class="alert alert-${type}" role="alert">${message}</div>`;
}
