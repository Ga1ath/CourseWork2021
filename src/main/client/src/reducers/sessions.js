import { FETCH_SESSIONS } from '../constants/actionTypes';

const reducer = (sessions = [], action) => {
  switch (action.type) {
    case FETCH_SESSIONS:
      return action.payload;
    default:
      return sessions;
  }
}

export default reducer;