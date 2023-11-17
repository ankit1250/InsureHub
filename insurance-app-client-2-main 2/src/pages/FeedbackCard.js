import React from 'react';
import { Avatar, Card, CardContent, Grid, Typography } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
  root: {
    width: 700,
    margin: '5%',
    padding: '5%',
    background: 'white',
    display: 'flex'
    // justifyContent: 'center',
    // alignItems: 'center'
  },
  avatar: {
    marginRight: theme.spacing(2)
  },
  title: {
    fontSize: '1.2rem',
    fontWeight: 'bold',
    margin: 0,
    textAlign: 'left',
    fontFamily: 'georgia'
  },
  user: {
    textAlign: 'left',
    fontWeight: 'italic',
    textColor: 'black',
    fontFamily: 'georgia'
  },
  description: {
    textAlign: 'left',
    fontWeight: 'italic',
    fontFamily: 'georgia'
  },
  date: {
    textAlign: 'left',
    fontWeight: 'italic',
    fontFamily: 'georgia'
  }
}));
const imgLink =
  'data:image/jpeg;base64,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';

export default function FeedbackCard(props) {
  const classes = useStyles();

  return (
    <>
      <Grid sx={{ textAlign: 'center' }} container spacing={2}>
        <Grid item xs={12} sm={6}>
          <Card className={classes.root}>
            <CardContent>
              <Grid container wrap="nowrap" spacing={2}>
                <Grid item>
                  <Avatar
                    alt="Anonymous User"
                    src={imgLink}
                    className={classes.avatar}
                  />
                </Grid>
                <Grid item xs zeroMinWidth>
                  <Typography className={classes.title}>
                    {props.fb.title}
                  </Typography>
                  <Typography className={classes.user}>
                    <i>Anonymous User</i>
                  </Typography>
                  <Typography className={classes.description}>
                    {props.fb.description}
                  </Typography>
                  <Typography className={classes.date}>
                    {props.fb.date}
                  </Typography>
                </Grid>
              </Grid>
            </CardContent>
          </Card>
        </Grid>
      </Grid>
    </>
  );
}
