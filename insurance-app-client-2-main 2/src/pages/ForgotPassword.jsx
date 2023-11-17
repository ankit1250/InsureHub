import Typography from '@mui/material/Typography';
import { useForm, Controller } from 'react-hook-form';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Link from '@mui/material/Link';
import MenuItem from '@mui/material/MenuItem';
import toast from 'react-hot-toast';
import { useNavigate } from 'react-router-dom';
import axios from '../utils/axios';
import useAuth from '../hooks/useAuth';

export const securityQuestions = [
  "What is your mother's maiden name?",
  'In which city were you born?',
  'What is the name of your first pet?',
  'What is your favorite movie?',
  'What was the model of your first car?',
  'What is the name of your favorite teacher?',
  'What is the street where you grew up?',
  'What is your favorite book?',
  'Who is your childhood best friend?',
  'What is your favorite vacation destination?',
  'What is the make of your first mobile phone?',
  'What is the name of the elementary school you attended?',
  'What is your favorite color?',
  'What is your favorite food?',
  'What is your dream job?',
  'What is the name of your favorite sports team?',
  'What is the year of your high school graduation?',
  'What is the nickname your friends gave you?',
  'What is your favorite hobby?'
];

export default function ForgotPassword() {
  const { auth, setAuth } = useAuth();
  const {
    handleSubmit,
    control,
    formState: { errors }
  } = useForm();
  const navigate = useNavigate();

  const onSubmit = async ({
    username,
    securityQuestion,
    securityAnswer,
    password
  }) => {
    try {
      const response = await axios.post('/auth/forgotpassword', {
        username,
        securityQuestion,
        securityAnswer,
        newPassword: password
      });
      toast.success('Password Reset done succesfully');
      navigate('/login');
      setAuth({});
    } catch (error) {
      toast.error('Password Reset failed');
      console.error(error);
    }
  };
  return (
    <div className="flex items-center justify-center">
      <form
        className="m-10 p-10 max-w-lg bg-white"
        onSubmit={handleSubmit(onSubmit)}
      >
        {auth?.token ? (
          <Typography variant="h4" gutterBottom>
            Reset Password
          </Typography>
        ) : (
          <Typography variant="h4" gutterBottom>
            Forgot Password
          </Typography>
        )}

        <Controller
          name="username"
          control={control}
          defaultValue=""
          rules={{
            required: 'Username is required'
          }}
          render={({ field }) => (
            <TextField
              {...field}
              label="Username"
              margin="normal"
              fullWidth
              error={!!errors.username}
              helperText={errors.username?.message}
            />
          )}
        />
        <Controller
          name="securityQuestion"
          control={control}
          defaultValue={securityQuestions[0]}
          rules={{
            required: 'Security question is required'
          }}
          render={({ field }) => (
            <TextField
              {...field}
              select
              label="Security Question"
              margin="normal"
              fullWidth
              error={!!errors.securityQuestion}
              helperText={errors.securityQuestion?.message}
            >
              {securityQuestions.map((question, index) => (
                <MenuItem key={index} value={question}>
                  {question}
                </MenuItem>
              ))}
            </TextField>
          )}
        />
        <br />

        <Controller
          name="securityAnswer"
          control={control}
          defaultValue=""
          rules={{
            required: 'Answer to security question is required'
          }}
          render={({ field }) => (
            <TextField
              {...field}
              label="Answer to Security Question"
              margin="normal"
              fullWidth
              error={!!errors.securityAnswer}
              helperText={errors.securityAnswer?.message}
            />
          )}
        />
        <br />
        <Controller
          name="password"
          control={control}
          defaultValue=""
          rules={{
            required: 'Password is required'
          }}
          render={({ field }) => (
            <TextField
              {...field}
              type="password"
              label="Password"
              margin="normal"
              fullWidth
              error={!!errors.password}
              helperText={errors.password?.message}
            />
          )}
        />
        <br />
        <Button
          type="submit"
          variant="contained"
          color="primary"
          style={{ marginTop: '10px' }}
        >
          Submit
        </Button>

        <Typography variant="body2" style={{ marginTop: '10px' }}>
          Don't have an account? <Link href="/register">Register</Link>
        </Typography>
        <Typography variant="body2" style={{ marginTop: '10px' }}>
          Remember your password? <Link href="/login">Login</Link>
        </Typography>
      </form>
    </div>
  );
}
