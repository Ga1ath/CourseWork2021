import { SHOW_POPUP, HIDE_POPUP } from '../constants/actionTypes';

const authReducer = (state = { visible: false }, action) => {
	switch (action.type) {
		case SHOW_POPUP:
			return { visible: true }
		case HIDE_POPUP:
			return { visible: false }
		default:
			return state;
	}
}

export default authReducer;