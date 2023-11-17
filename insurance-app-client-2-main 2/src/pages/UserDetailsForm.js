import React from 'react';
import { useOrder } from '../context/OrderContext';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { styled } from '@mui/material/styles';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import TextField from '@mui/material/TextField';
import {
  Radio,
  FormControl,
  FormControlLabel,
  RadioGroup
} from '@mui/material';

function UserDetailsForm(props) {
  const {
    cart,
    order,
    userId,
    purchaseDate,
    udm,
    addOrder,
    setUdm,
    deleteCart,
    orderPrice
  } = useOrder();

  const handleChange = (event) => {
    const { name, value, type, checked } = event.target;

    setUdm((prevUdm) => ({
      ...prevUdm,
      [name]: type === 'checkbox' ? checked : value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log('Form submitted:', udm);
  };

  return (
    <div
      style={{
        textAlign: 'center',
        padding: '20px',
        maxWidth: '600px',
        margin: 'auto',
        marginTop: '30px',
        marginBottom: '30px',
        border: '2px solid #1976D2', // Blue border color
        borderRadius: '10px', // Rounded corners
        boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)', // Subtle shadow
        backgroundColor: 'white' // Background color
      }}
    >
      <toolbar>
        <h1 style={{ color: '#1976D2' }}>PERSONAL DETAILS FORM</h1>
      </toolbar>
      <form
        onSubmit={handleSubmit}
        style={{ maxWidth: '500px', margin: 'auto' }}
      >
        <TextField
          style={{ width: '500px', margin: '5px' }}
          label="Name"
          variant="outlined"
          name="userName"
          value={udm.userName}
          onChange={handleChange}
        />
        <br />
        <TextField
          style={{ width: '500px', margin: '5px' }}
          type="number"
          label="Age"
          variant="outlined"
          name="age"
          value={udm.age}
          onChange={handleChange}
        />
        <br />
        {/* <TextField
          style={{ width: '500px', margin: '5px' }}
          type="text"
          label="Tobacco Consumer?"
          variant="outlined"
          name="isTobaccoConsumer"
          value={udm.isTobaccoConsumer}
          onChange={handleChange}
        />
        <br />
        <TextField
          style={{ width: '500px', margin: '5px' }}
          type="text"
          label="Do you drink alcohol?"
          variant="outlined"
          name="doesUserDrink"
          value={udm.doesUserDrink}
          onChange={handleChange}
        />
        <br /> */}
        <TextField
          style={{ width: '500px', margin: '5px' }}
          type="text"
          label="Nominee Name"
          variant="outlined"
          name="nomineeName"
          value={udm.nomineeName}
          onChange={handleChange}
        />
        <br />
        <TextField
          style={{ width: '500px', margin: '5px' }}
          type="number"
          label="Nominee Age"
          variant="outlined"
          name="nomineeAge"
          value={udm.nomineeAge}
          onChange={handleChange}
        />
        <br />
        <TextField
          style={{ width: '500px', margin: '5px' }}
          type="text"
          label="Nominee Relation"
          variant="outlined"
          name="nomineeRelation"
          value={udm.nomineeRelation}
          onChange={handleChange}
        />
        <FormControl
          component="fieldset"
          style={{ margin: '10px', color: 'grey' }}
        >
          <RadioGroup
            row
            aria-label="Tobacco Consumer"
            name="isTobaccoConsumer"
            value={udm.isTobaccoConsumer}
            onChange={handleChange}
          >
            <FormControlLabel
              value="true"
              control={<Radio />}
              label="Consume Tobacco"
            />
            <FormControlLabel
              value="false"
              control={<Radio />}
              label="Doesn't consume"
            />
          </RadioGroup>
        </FormControl>

        <br />

        <FormControl
          component="fieldset"
          style={{ margin: '10px', color: 'grey' }}
        >
          <RadioGroup
            row
            aria-label="Do you drink alcohol?"
            name="doesUserDrink"
            value={udm.doesUserDrink}
            onChange={handleChange}
          >
            <FormControlLabel
              value="true"
              control={<Radio />}
              label="Drinks Alcohol"
            />
            <FormControlLabel
              value="false"
              control={<Radio />}
              label="Doesn't Drink Alcohol"
            />
          </RadioGroup>
        </FormControl>
        <br />
        <br />
        <br />
        {/* <Button type="submit" variant="contained" color="primary">
          Save
        </Button> */}
      </form>
    </div>
  );
}

export default UserDetailsForm;
