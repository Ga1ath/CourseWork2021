import { FETCH_CURRENT_SESSION } from '../constants/actionTypes';

import * as api from '../api/index';

export const getCurrentSession = (sessionId) => async (dispatch) => {
  try {
    const { data } =  await api.fetchCurrentSession(sessionId);

    dispatch({ type: FETCH_CURRENT_SESSION, payload: data })
  } catch (err) {
    console.log(err);
  }
}