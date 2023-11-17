import { Link } from 'react-router-dom';
import useAuth from '../hooks/useAuth';
import { useNavigate, Navigate } from 'react-router-dom';
import toast from 'react-hot-toast';
// import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';

const Navbar = () => {
  const { auth, setAuth } = useAuth();
  const navigate = useNavigate();
  const isAdmin = sessionStorage.getItem('admin') === 'true';
  const handlelogout = () => {
    if (isAdmin) {
      sessionStorage.removeItem('admin');
      console.log('Admin logged out');
      Navigate('/login');
      toast.success('Logout success');
      return;
    }
    setAuth({});
    localStorage.removeItem('auth');
    navigate('/');
    toast.success('Logout success');
  };
  return (
    <div className="lg:flex lg:flex-row flex-col justify-end items-center space-x-3 p-3 bg-slate-600 text-white">
      <div className="flex-grow flex items-center">
        <img
          className="p-2"
          width="64"
          height="64"
          src="https://img.icons8.com/cotton/64/security-checked--v3.png"
          alt="security-checked--v3"
        />
        <h1 className="text-3xl font-extrabold">InsureHub</h1>
      </div>
      {auth?.token && (
        <p className="text-yellow-300 flex text-lg">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth={1.5}
            stroke="currentColor"
            className="w-8 h-8 pr-1"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z"
            />
          </svg>
          Hi! {auth?.name}
        </p>
      )}
      <Link to="/">Home</Link>
      {isAdmin && <Link to="/feedback">Feedback</Link>}
      {!auth?.token && !isAdmin && (
        <>
          <Link to="/register">Register</Link>
          <Link
            className="bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded"
            to="/login"
          >
            Login
          </Link>
        </>
      )}
      {auth?.token && (
        <>
          <Link to="/feedback-form">Feedback Form</Link>
          <Link to="/forgot-password">Reset Password</Link>
          <Link to="/cart" className="flex space-x-1">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              strokeWidth={1.5}
              stroke="currentColor"
              className="w-6 h-6 pr-1"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                d="M2.25 3h1.386c.51 0 .955.343 1.087.835l.383 1.437M7.5 14.25a3 3 0 00-3 3h15.75m-12.75-3h11.218c1.121-2.3 2.1-4.684 2.924-7.138a60.114 60.114 0 00-16.536-1.84M7.5 14.25L5.106 5.272M6 20.25a.75.75 0 11-1.5 0 .75.75 0 011.5 0zm12.75 0a.75.75 0 11-1.5 0 .75.75 0 011.5 0z"
              />
            </svg>
            Cart
          </Link>
          <Link to="/dashboard">Dashboard</Link>
          <Link
            className="bg-red-500 hover:bg-red-400 text-white font-bold py-2 px-4 border-b-4 border-red-700 hover:border-red-500 rounded"
            onClick={handlelogout}
          >
            Logout
          </Link>
        </>
      )}
      {isAdmin && (
        <Link
          className="bg-red-500 hover:bg-red-400 text-white font-bold py-2 px-4 border-b-4 border-red-700 hover:border-red-500 rounded"
          onClick={handlelogout}
        >
          Logout
        </Link>
      )}
    </div>
  );
};

export default Navbar;
