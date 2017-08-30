package com.tgb.lk.demo.gson.test6;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EnumSerializer implements JsonSerializer<PackageState>,
		JsonDeserializer<PackageState> {

	// ����תΪJsonʱ����,ʵ��JsonSerializer<PackageState>�ӿ�
	@Override
	public JsonElement serialize(PackageState state, Type arg1,
			JsonSerializationContext arg2) {
		return new JsonPrimitive(state.ordinal());
	}

	// jsonתΪ����ʱ����,ʵ��JsonDeserializer<PackageState>�ӿ�
	@Override
	public PackageState deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		if (json.getAsInt() < PackageState.values().length)
			return PackageState.values()[json.getAsInt()];
		return null;
	}

}
