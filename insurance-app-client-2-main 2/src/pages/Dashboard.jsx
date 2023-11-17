import React from 'react';
import PolicyBuyerDashboard from '../components/PolicyBuyerDashboard';
import { Typography } from '@mui/material';

export default function Dashboard() {
  return (
    <div className="p-5 m-5">
      <div className="flex justify-center">
        <Typography variant="h4" gutterBottom>
          Your Policies
        </Typography>
      </div>
      <PolicyBuyerDashboard />
    </div>
  );
}
