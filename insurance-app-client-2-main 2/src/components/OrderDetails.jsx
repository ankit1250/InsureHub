import React from 'react';
import { Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';
const cardStyles = {
  width: '30%',
  border: '1px solid #ddd',
  borderRadius: '8px',
  boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
  marginBottom: '10px'
};

const OrderDetails = ({ order, onPolicyClick }) => {
  return (
    <div className="p-2 m-2 flex flex-row flex-wrap items-start justify-center">
      <Card style={cardStyles} className="">
        <CardContent>
          <Typography variant="h5" component="div">
            Order ID: {order.orderId}
          </Typography>
          <Typography color="text.secondary">
            Purchase Date: {order.purchaseDate}
          </Typography>
          <Typography color="text.secondary">
            Order Price: {order.orderPrice}
          </Typography>
          <Typography color="text.secondary">
            Nominee name: {order.udm.nomineeName}
          </Typography>
          <Typography color="text.secondary">
            Nominee relation: {order.udm.nomineeRelation}
          </Typography>

          {order.policyAddOn.map((policy) => (
            <Button
              color="primary"
              key={policy.id}
              component={Link}
              onClick={() => onPolicyClick(policy)}
              style={{ marginRight: '10px', marginTop: '5px' }}
            >
              {policy.policy.policyName}
            </Button>
          ))}
        </CardContent>
      </Card>
    </div>
  );
};

export default OrderDetails;
