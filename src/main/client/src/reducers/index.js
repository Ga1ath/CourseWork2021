import { combineReducers } from 'redux';

import postReducer from './posts';
import authReducer from './auth';
import sessionReducer from './sessions';
import toggleReducer from './toggle';

export const reducers = combineReducers({
  menu: toggleReducer,
  posts: postReducer,
  authReducer,
  filmInfo: sessionReducer
});
