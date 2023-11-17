import { createContext, useContext, useState, useEffect } from 'react';
import axios from '../utils/axios';
import toast from 'react-hot-toast';
import useAuth from '../hooks/useAuth';
import { useNavigate } from 'react-router-dom';

const OrderContext = createContext();

export const useOrder = () => {
  return useContext(OrderContext);
};

export const OrderProvider = ({ children }) => {
  const { auth } = useAuth();
  const navigate = useNavigate();
  const currentDate = new Date();
  const year = currentDate.getFullYear();
  const month = (currentDate.getMonth() + 1).toString().padStart(2, '0');
  const day = currentDate.getDate().toString().padStart(2, '0');

  const formattedDate = `${year}-${month}-${day}`;

  const [cart, setCart] = useState(null);
  const [order, setOrder] = useState([]);
  const [userId, setUserId] = useState(auth?.userId);
  const [policyAddOn, setPolicy] = useState([]);
  const [orderPrice, setOrderPrice] = useState(0);
  const [purchaseDate, setPurchaseDate] = useState(formattedDate);
  // const [cartReqIds,setCartReqIds]=useState([])
  const [cartChanged, setCartChanged] = useState(false);

  const [udm, setUdm] = useState({
    userName: '',
    age: 0,
    isTobaccoConsumer: false,
    doesUserDrink: false,
    nomineeName: '',
    nomineeAge: 0,
    nomineeRelation: ''
  });
  const fetchCartItems = async () => {
    try {
      const response = await axios.get(`/shoppingcart/${auth?.userId}/buyCart`);
      return response.data;

      console.log(orderPrice);
    } catch (error) {
      console.error('Error fetching cart items:', error);
    }
  };

  useEffect(() => {
    const fetchAndSetCart = async () => {
      try {
        const data = await fetchCartItems();
        setCart([...data]);
        const response = await axios.get(
          `/shoppingcart/getTotalPrice/${auth?.userId}`
        );
        setOrderPrice(response.data);
      } catch (error) {
        console.error('Error fetching cart items:', error);
      }

      //  let cartRequestArray=[]
      //  cart?.map((c)=>(
      //     cartRequestArray.push(c.cartRequestId)
      //  ))
      // //  console.log(cartRequestArray)
      //  setCartReqIds(prevArray => [...prevArray, ...cartRequestArray]);
    };

    fetchAndSetCart();
    setCartChanged(false);
  }, [cartChanged, auth?.userId]);
  //   console.log(cart)
  // console.log(cartReqIds);

  const calculateTotalOrderPrice = () => {
    return cart?.reduce((total, c) => total + c.price, 0) || 0;
  };

  //   console.log(orderPrice)
  const deleteCart = (cartId) => {
    try {
      // Replace 'your_api_endpoint' with the actual URL of your API endpoint
      const response = axios.delete(
        `/shoppingcart/deleteItemFromCart/${cartId}`
      );

      // Handle the response or perform additional actions
      console.log('Deleted successfully:', response.data);
      toast.success('Deleted successfully');
    } catch (error) {
      // Handle errors
      console.error('Error deleting data:', error.message);
    }
    console.log(cartId);
    setCartChanged(!cartChanged);
    // window.location.reload();
  };

  const addOrder = () => {
    // const totalOrderPrice = calculateTotalOrderPrice();

    let policyArray = [];
    let res = 0;
    cart?.forEach((element) => {
      policyArray.push({
        policyId: element.policy.policyId,
        price: element.price
      });

      res += element.price;
    });

    setPolicy((prevPolicyAddOn) => {
      const updatedPolicyAddOn = [...prevPolicyAddOn, ...policyArray];

      return updatedPolicyAddOn;
    });

    setOrder((prevOrder) => {
      const updatedOrder = [
        ...prevOrder,
        {
          userId,
          purchaseDate,
          policyAddOn: [...policyArray],
          udm,
          orderPrice: res
        }
      ];
      console.log(updatedOrder[0]);

      const headers = {
        'Content-Type': 'application/json'
      };

      try {
        const response = axios.post(
          '/order/addOrderWithUserDetails',
          updatedOrder[0],
          { headers }
        );
        console.log(response.status);
      } catch (error) {
        console.error('Error posting order:', error.message);
      }
      //   return updatedOrder;
    });

    try {
      const response = axios.delete(
        `/shoppingcart/deleteByUserId/${auth.userId}`
      );
      console.log('Deleted successfully:', response.data);
    } catch (error) {
      console.error('Error deleting data:', error.message);
    }
    // window.location.reload();
    setUdm({
      userName: '',
      age: 0,
      isTobaccoConsumer: false,
      doesUserDrink: false,
      nomineeName: '',
      nomineeAge: 0,
      nomineeRelation: ''
    });
    toast.success('Order Placed Successfully');
    setCartChanged(!cartChanged);
    navigate('/feedback-form');
  };

  const contextValue = {
    cart,
    order,
    userId,
    purchaseDate,
    udm,
    setUdm,
    addOrder,
    deleteCart,
    orderPrice,
    setCartChanged
  };

  return (
    <OrderContext.Provider value={contextValue}>
      {children}
    </OrderContext.Provider>
  );
};
