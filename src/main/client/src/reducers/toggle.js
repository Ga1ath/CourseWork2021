import { HIDE_MENU, SHOW_MENU } from "../constants/actionTypes";

const InitialState = {
	showSidebar: false,
}

const toggleReducer = (state = InitialState, action) => {
	switch (action.type) {
		case SHOW_MENU:
			return { ...state, showSidebar: true }
		case HIDE_MENU:
			return { ...state, showSidebar: false }
		default:
			return state
	}
}

export default toggleReducer;