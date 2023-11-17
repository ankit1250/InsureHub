import { Outlet, useLocation, Navigate } from 'react-router-dom';
import useAuth from '../hooks/useAuth';

export default function AuthRequired() {
  const { auth } = useAuth();
  const location = useLocation();

  return auth?.token ? (
    <Outlet />
  ) : (
    <Navigate to="/login" state={{ from: location }} replace />
  );
}
