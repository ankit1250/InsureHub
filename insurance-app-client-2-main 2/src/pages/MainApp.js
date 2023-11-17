import React from 'react';
import BackendCall from './BackendCall';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';

function MainApp(props) {
  const isAdmin = sessionStorage.getItem('admin') === 'true';
  return isAdmin ? (
    <div className="flex flex-col justify-center items-center m-5 p-5">
      <Typography variant="h4" gutterBottom>
        Feedback
      </Typography>
      <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
        <Grid item xs={6}>
          <img
            src="https://img.freepik.com/free-vector/business-people-arranging-appointment-digital-booking-app_74855-20006.jpg?w=996&t=st=1700061826~exp=1700062426~hmac=eec04d60c5ec75911f8f1139f98b68fe193bbf6ff6af3e806dc4292aab5372cc"
            alt="Your Image"
            style={{
              padding: '20px',
              height: '100%',
              width: '100%',
              aspectRatio: 'auto',
              backgroundBlendMode: 'hard-light'
            }}
          />
        </Grid>
        <Grid item xs={6}>
          <BackendCall />
        </Grid>
      </Grid>
    </div>
  ) : (
    <div className="flex justify-center items-center m-5 p-5">
      <Typography variant="h4" gutterBottom>
        You are not logged in as Admin
      </Typography>
    </div>
  );
}

export default MainApp;
