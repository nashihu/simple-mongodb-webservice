//package com.ahmadmongo.ahmadmongo.importedClass;
//
//import iconpln.common.json.util.JsonUtil;
//import iconpln.common.model.http.HttpResponseModel;
//import iconpln.common.model.http.PageableModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public final class DecodeUtil {
//    private DecodeUtil() {
//    }
//
//    public static <T> T decode(HttpResponseModel model, Class<T> clazz) {
//        return JsonUtil.decode(JsonUtil.encode(model.getData()), clazz);
//    }
//
//    public static <T> List<T> decodeList(HttpResponseModel model, Class<T> clazz) {
//        List<T> result = new ArrayList();
//        if (!model.isSuccess()) {
//            return result;
//        } else {
//            List<T> list = (List)model.getData();
//            list.forEach((o) -> {
//                result.add(JsonUtil.decode(JsonUtil.encode(o), clazz));
//            });
//            return result;
//        }
//    }
//
//    public static <T> PageableModel<List<T>> decodePageable(HttpResponseModel model, Class<T> clazz) {
//        PageableModel<List<T>> result = new PageableModel();
//        if (!model.isSuccess()) {
//            return result;
//        } else {
//            PageableModel tempPageable = (PageableModel)JsonUtil.decode(JsonUtil.encode(model.getData()), PageableModel.class);
//            List<T> tempList = (List)tempPageable.getContents();
//            List<T> resultList = new ArrayList();
//            tempList.forEach((t) -> {
//                resultList.add(JsonUtil.decode(JsonUtil.encode(t), clazz));
//            });
//            result.setContents(resultList);
//            result.setPageDetail(tempPageable.getPages());
//            result.setSort(tempPageable.getSort());
//            return result;
//        }
//    }
//}
