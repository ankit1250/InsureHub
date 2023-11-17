import { createContext, useState, useEffect } from 'react';

const AuthContext = createContext({});

export const AuthProvider = ({ children }) => {
  const [auth, setAuth] = useState(() => {
    try {
      return JSON.parse(localStorage.getItem('auth')) || {};
    } catch {
      return {};
    }
  });

  useEffect(() => {
    // Write user and token to localStorage whenever auth state changes
    if (Object.keys(auth).length > 0) {
      localStorage.setItem('auth', JSON.stringify(auth));
    }
    // clear localStorage when auth state is empty
    else {
      localStorage.removeItem('auth');
    }
  }, [auth]); // This tells React to call this effect whenever auth state changes

  return (
    <AuthContext.Provider value={{ auth, setAuth }}>
      {children}
    </AuthContext.Provider>
  );
};

export default AuthContext;
