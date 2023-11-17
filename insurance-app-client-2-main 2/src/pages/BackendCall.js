import React, { useState, useEffect } from 'react';
import axios from '../utils/axios';
import FeedbackCard from './FeedbackCard';

function GetFeedback(props) {
  const [feedback, setFeedback] = useState([]);

  useEffect(() => {
    const fetchFeedback = async () => {
      try {
        //const response = await axios.get('http://localhost:8092/feedback/policybuyerfeedback/9');
        const response = await axios.get('/feedback/policybuyerfeedback');
        setFeedback((prevFeedback) => [...prevFeedback, response.data]);
        //setFeedback(response.data)
      } catch (error) {
        console.error('Error fetching feedback:', error);
      }
    };

    fetchFeedback();
  }, []);

  console.log(feedback);

  return (
    <div>
      {feedback[0] ? (
        feedback[0].map((fb) => <FeedbackCard key={fb.id} fb={fb} />)
      ) : (
        <p>Loading feedback...</p>
      )}
    </div>
  );
}

export default GetFeedback;
