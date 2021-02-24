import { combineReducers } from 'redux';

import postReducer from './posts';
import authReducer from './auth';
import sessionReducer from './sessions';

export const reducers = combineReducers({
  postReducer, authReducer, sessionReducer
});