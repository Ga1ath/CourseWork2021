import { SHOW_POPUP, HIDE_POPUP } from "../constants/actionTypes";

export const showHallPopup = () => {
	return {
		type: SHOW_POPUP
	}
}

export const hideHallPopup = () => {
	return {
		type: HIDE_POPUP
	}
}