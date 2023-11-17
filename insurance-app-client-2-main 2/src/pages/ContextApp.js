import React, { useState } from 'react';
import { useOrder } from '../context/OrderContext';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { styled } from '@mui/material/styles';
import Paper from '@mui/material/Paper';

function ContextApp() {
  const { cart, addOrder, deleteCart, orderPrice } = useOrder();

  const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.text.secondary
  }));

  return (
    <div>
      <Item>
        <toolbar>
          <Typography variant="h4" gutterBottom>
            Your Cart
          </Typography>
          <div>
            {cart?.length === 0 ? (
              <h1>Your cart is empty!</h1>
            ) : (
              <div className="flex justify-center items-center space-x-6">
                <Typography variant="h6" gutterBottom>
                  Total Price: {orderPrice}
                </Typography>
                {/* Total Price: {orderPrice}{' '} */}
                <Button onClick={addOrder} variant="contained" color="primary">
                  Buy Now
                </Button>
              </div>
            )}
          </div>
        </toolbar>
        {cart?.length > 0 &&
          cart?.map((c) => (
            <div className="card" key={c.policy.policyId}>
              <Box
                sx={{
                  display: 'flex',
                  justifyContent: 'center',
                  alignItems: 'center',
                  height: '25vh'
                }}
              >
                <Card
                  sx={{
                    width: 600,
                    backgroundColor: '#D9E3F5', // Light background color
                    boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)', // Subtle shadow
                    borderRadius: '8px',
                    transition: 'transform 0.3s',
                    '&:hover': {
                      transform: 'scale(1.02)'
                    }
                  }}
                  variant="outlined"
                >
                  <CardContent>
                    <Typography color="text.secondary" gutterBottom>
                      <b>
                        <h2>{c.policy.policyName}</h2>
                      </b>
                    </Typography>
                    <Typography component="div">
                      <b>{c.policyCompany}</b>
                    </Typography>
                    <Typography sx={{ mb: 1.5 }} color="text.secondary">
                      {c.policy.policyType.policyTypeValue} Insurance
                    </Typography>
                    <Typography color="text.secondary">
                      <b>$ {c.price}</b>
                    </Typography>
                    <Typography variant="body2">
                      {c.policy.benefit.benefitValue.replace(/"/g, ' ')}
                    </Typography>
                    <br />
                    <Button
                      onClick={() => deleteCart(c.cartRequestId)}
                      variant="outlined"
                      color="error"
                    >
                      REMOVE
                    </Button>
                  </CardContent>
                </Card>
              </Box>
            </div>
          ))}
      </Item>

      <Item></Item>
    </div>
  );
}

export default ContextApp;
