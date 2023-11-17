import { TableCell } from '@mui/material';
import { useState, useEffect } from 'react';
import axios from '../utils/axios';

export default function DiscountPrice({ price, id }) {
  const [data, setData] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          `/discount/getdiscountbypolicyid/${id}`
        );
        setData(response.data);
        setIsLoaded(true);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
    fetchData();
  }, [id]);

  const discountedPrice = price - (data?.percentage / 100) * price;
  console.log(discountedPrice);
  // if discountedPrice is NaN, then set it to price
  if (isNaN(discountedPrice)) {
    // onDiscountedPrice(price);
    sessionStorage.setItem(id, price);
  } else {
    sessionStorage.setItem(id, discountedPrice);
  }

  return isLoaded ? (
    <TableCell align="right">
      <s>{price}</s>&nbsp;
      {discountedPrice}
    </TableCell>
  ) : (
    <TableCell align="right">{price}</TableCell>
  );
}
