import PolicyTable from '../components/PolicyTable';
import { useState } from 'react';
import Button from '@mui/material/Button';
import banner from '../assets/banner.png';

export const insuranceTypes = [
  'Health Insurance',
  'Life Insurance',
  'Two-wheeler Insurance',
  'Property Insurance',
  'Car Insurance'
];
export default function Home() {
  const [id, setId] = useState(1);

  const checkDisabled = (buttonId) => {
    return id === buttonId ? true : false;
  };

  return (
    <div className="flex flex-col p-1 m-1 lg:m-5 lg:p-5">
      <img src={banner} className="mb-5 max-w-full" />
      <div className="flex justify-center items-center md:space-x-4 flex-col md:flex-row space-x-2 m-3">
        {insuranceTypes.map((insuranceType, index) => (
          <Button
            key={index}
            variant="contained"
            disabled={checkDisabled(index + 1)}
            onClick={() => setId(index + 1)}
          >
            {insuranceType}
          </Button>
        ))}
      </div>
      <div className="flex items-center justify-center lg:m-5 lg:p-5 mx-1 px-2 my-5 py-5">
        <PolicyTable id={id} />
      </div>
    </div>
  );
}
