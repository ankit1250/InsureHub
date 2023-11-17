// create cart context
const CartContext = createContext({
  cart: {},
  setCart: () => {}
});

// create cart provider
export const CartProvider = ({ children }) => {
  const initialCartState = JSON.parse(localStorage.getItem('cart')) || {};
  const [cart, setCart] = useState(initialCartState);

  useEffect(() => {
    // Write cart to localStorage whenever cart state changes
    if (Object.keys(cart).length > 0) {
      localStorage.setItem('cart', JSON.stringify(cart));
    }
  }, [cart]); // This tells React to call this effect whenever cart state changes

  return (
    <CartContext.Provider value={{ cart, setCart }}>
      {children}
    </CartContext.Provider>
  );
};
