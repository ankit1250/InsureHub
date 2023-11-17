import { Routes, Route } from 'react-router-dom';
import Cart from './pages/Cart';
import Layout from './components/Layout';
import Login from './pages/Login';
import Register from './pages/Register';
import ForgotPassword from './pages/ForgotPassword';
import Home from './pages/Home';
import AuthRequired from './utils/AuthRequired';
import MainApp from './pages/MainApp';
import FeedbackForm from './pages/FeedbackForm';
import Dashboard from './pages/Dashboard';
// import NotFound from './pages/NotFound';

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        {/* public routes */}
        <Route path="login" element={<Login />} />
        <Route path="register" element={<Register />} />
        <Route path="forgot-password" element={<ForgotPassword />} />
        <Route path="feedback" element={<MainApp />} />
        {/* <Route path="404" element={<NotFound />} /> */}
        <Route path="/" element={<Home />} />
        {/* we want to protect these routes */}
        <Route element={<AuthRequired />}>
          <Route path="/cart" element={<Cart />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/feedback-form" element={<FeedbackForm />} />
        </Route>
        {/* catch all */}
        {/* <Route path="*" element={<Missing />} /> */}
      </Route>
    </Routes>
  );
}
