import React, { useEffect, useState } from 'react';
import OrderDetails from './OrderDetails';
import axios from '../utils/axios';
import useAuth from '../hooks/useAuth';
import { Route, Router } from 'react-router-dom';
import { Typography } from '@mui/material';

const containerStyles = {
  display: 'flex',
  justifyContent: 'column',
  margin: '20px'
};

const cardStyles = {
  width: '30%',
  border: '1px solid #ddd',
  borderRadius: '8px',
  boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
  marginBottom: '10px'
};

// const ordersData = [
//   {
//     orderId: 1,
//     purchaseDate: '2023-11-13',
//     orderPrice: 100.0,
//     policyAddOns: [
//       {
//         id: 101,
//         name: 'Policy B',
//         expiryDate: '2024-01-01',
//         nominee: 'Ankit Kumar'
//       }
//     ]
//   },
//   {
//     orderId: 2,
//     purchaseDate: '2023-11-14',
//     orderPrice: 150.0,
//     policyAddOns: [
//       {
//         id: 101,
//         name: 'Policy B',
//         expiryDate: '2024-01-01',
//         nominee: 'Ram Khatri'
//       }
//     ]
//   },
//   {
//     orderId: 3,
//     purchaseDate: '2023-11-15',
//     orderPrice: 120.0,
//     policyAddOns: [
//       {
//         id: 101,
//         name: 'Policy A',
//         expiryDate: '2024-01-01',
//         nominee: 'John Doe'
//       },
//       {
//         id: 102,
//         name: 'Policy B',
//         expiryDate: '2025-03-01',
//         nominee: 'Anshuman Malik'
//       }
//     ]
//   }
// ];
const PolicyInfo = ({ policy }) => {
  console.log('POlicy log' + policy);
  return (
    <div className="p-5 m-5 bg-white rounded-md border border-slate-300">
      <Typography variant="h4" gutterBottom>
        Policy Details
      </Typography>
      <Typography variant="h6" gutterBottom>
        Policy Name: {policy.policy.policyName}
      </Typography>
      <Typography color="text.secondary">
        Tenure: {policy.policy.tenure} year
      </Typography>
      <Typography color="text.secondary">
        Coverage: {policy.policy.coverage} INR
      </Typography>
    </div>
  );
};

function PolicyBuyerDashboard() {
  const [open, IsOpen] = useState(false);
  const { auth } = useAuth();
  const [data, setData] = useState([]);
  const [isLoaded, setIsLoaded] = useState(false);

  const [selectedPolicy, setSelectedPolicy] = useState(null);

  const handlePolicyClick = (policy) => {
    if (selectedPolicy == null) {
      setSelectedPolicy(policy);
    } else {
      setSelectedPolicy(null);
    }
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          `/order/getOrderByUserId/${auth?.userId}`,
          {
            headers: {
              Authorization: `Bearer ${auth?.token}`
              // Add any other headers if needed
            }
          }
        );

        setData((prevData) => [...prevData, response.data]);
        setIsLoaded(true);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
    fetchData();
  }, []);
  console.log(data);
  return (
    <div
      style={containerStyles}
      className="flex flex-col-reverse space-y-4 bg-neutral-200 rounded-md"
    >
      {isLoaded ? (
        data[0]?.map((order) => (
          <OrderDetails
            key={order.id}
            order={order}
            onPolicyClick={handlePolicyClick}
          />
        ))
      ) : (
        <p>Loading...</p>
      )}
      {selectedPolicy ? <PolicyInfo policy={selectedPolicy} /> : <></>}
    </div>
  );
}

export default PolicyBuyerDashboard;
