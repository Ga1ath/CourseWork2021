import React, { useEffect, useRef } from 'react';
import './styles.css'
import { useDispatch, useSelector } from "react-redux";
import { hideHallPopup } from "../../actions/hallPopup";

const BlurBg = (props) => {

	return (
		<div className="blurbg">
			{props.children}
		</div>
	);
};

export default BlurBg;