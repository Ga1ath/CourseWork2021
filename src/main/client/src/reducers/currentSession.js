import { FETCH_CURRENT_SESSION } from '../constants/actionTypes';

const reducer = (seats = [], action) => {
  switch (action.type) {
    case FETCH_CURRENT_SESSION:
      return action.payload;
    default:
      return seats;
  }
}

export default reducer;