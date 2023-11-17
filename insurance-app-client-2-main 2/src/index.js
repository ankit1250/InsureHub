import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { AuthProvider } from './context/AuthProvider';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { OrderProvider } from './context/OrderContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <>
    <BrowserRouter>
      <AuthProvider>
        <OrderProvider>
          <Routes>
            <Route path="/*" element={<App />} />
          </Routes>
        </OrderProvider>
      </AuthProvider>
    </BrowserRouter>
  </>
);
