import React from 'react';
import { useState } from 'react';
import {
  Grid,
  TextField,
  Button,
  Card,
  CardContent,
  Typography
} from '@material-ui/core';
import axios from '../utils/axios';
import toast from 'react-hot-toast';
import { useNavigate } from 'react-router-dom';

export default function FeedbackForm() {
  const navigate = useNavigate();
  const currentDate = new Date();
  const year = currentDate.getFullYear();
  const month = (currentDate.getMonth() + 1).toString().padStart(2, '0');
  const day = currentDate.getDate().toString().padStart(2, '0');

  const formattedDate = `${year}-${month}-${day}`;

  const [feedback, setfeedback] = useState({
    title: '',
    description: '',
    date: formattedDate
  });
  const handleChange = (event) => {
    const { name, value, type, checked } = event.target;

    setfeedback((prev) => ({
      ...prev,
      [name]: type === 'checkbox' ? checked : value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    postfeedback();
    console.log('Form submitted');
    navigate('/dashboard');
  };

  const postfeedback = async () => {
    try {
      console.log(feedback);
      const response = await axios.post('/feedback/pbfeedback', feedback);
      toast.success('Feedback submitted successfully');
      return response;
      //  console.log(orderPrice)
    } catch (error) {
      console.error('Error fetching details:', error);
    }
  };

  return (
    <div className="flex justify-center items-center p-10 m-20">
      <Grid container spacing={2}>
        <Grid item xs={6} className="flex-grow">
          <img
            src="https://img.freepik.com/free-vector/organic-flat-feedback-concept_52683-62653.jpg?w=996&t=st=1700065075~exp=1700065675~hmac=2d7bfad5a97eed3664834fbf2f949c4acfa934b3a56e81c896e96fef6c898f63"
            alt="Your Image"
            style={{
              padding: '20px',
              height: '100%',
              width: '150%',
              aspectRatio: 'auto',
              backgroundBlendMode: 'color'
            }}
          />
        </Grid>
        <Grid item xs={6}>
          <Grid>
            <Card
              style={{ maxWidth: 450, padding: '100px 5px', margin: '0 auto' }}
            >
              <CardContent>
                <Typography gutterBottom variant="h5">
                  FEEDBACK FORM
                </Typography>
                <Typography
                  variant="body2"
                  color="textSecondary"
                  component="p"
                  gutterBottom
                >
                  Please provide your valuable Feedback
                </Typography>
                <form onSubmit={handleSubmit} className="m-2 p-2">
                  <Grid container spacing={1}>
                    <Grid item xs={12}>
                      <TextField
                        type="text"
                        onChange={handleChange}
                        placeholder="Title"
                        name="title"
                        value={feedback.title}
                        label="Title"
                        variant="outlined"
                        fullWidth
                        required
                      />
                    </Grid>
                    <Grid item xs={12}>
                      <TextField
                        label="Description"
                        onChange={handleChange}
                        type="text"
                        name="description"
                        value={feedback.description}
                        multiline
                        rows={4}
                        placeholder="Type your message here"
                        variant="outlined"
                        fullWidth
                        required
                      />
                    </Grid>
                    <Grid item xs={12}>
                      <Button
                        type="submit"
                        variant="contained"
                        color="primary"
                        fullWidth
                      >
                        Submit
                      </Button>
                    </Grid>
                  </Grid>
                </form>
              </CardContent>
            </Card>
          </Grid>
        </Grid>
      </Grid>
    </div>
  );
}
