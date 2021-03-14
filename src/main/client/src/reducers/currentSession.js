import { FETCH_CURRENT_SESSION } from '../constants/actionTypes';

const initialState =
  [
    [
      {
        name: "1b",
        isBooked: true
      },
      {
        name: "1c",
          isBooked: false
      },
      {
        name: "1d",
          isBooked: true
      }
      ],
    [
      {
        name: "2b",
        isBooked: false
      },
        {
          name: "2c",
          isBooked: true
        },
        {
          name: "2d",
          isBooked: false
        }
      ]
  ]


const reducer = (seats = initialState, action) => {
  switch (action.type) {
    case FETCH_CURRENT_SESSION:
      return action.payload;
    default:
      return seats;
  }
}

export default reducer;